package ru.zhigalov.superkassa.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.zhigalov.superkassa.exception.ObjectNotFoundException;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class ExampleRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleRepository.class);
    private static final String SQL_QUERY = """
            UPDATE PUBLIC.SK_EXAMPLE_TABLE
            SET OBJ['current'] = TO_JSONB((OBJ ->> 'current')::INT + ?)
            WHERE ID = ? RETURNING OBJ['current'];
            """;

    private final DataSource dataSource;

    public ExampleRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int updateObjById(int id, int add) {
        try (var connection = dataSource.getConnection()) {
            var preparedStatement = connection.prepareStatement(SQL_QUERY);
            preparedStatement.setInt(1, add);
            preparedStatement.setInt(2, id);
            var resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new ObjectNotFoundException(id);
            }
            return resultSet.getInt(1);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
