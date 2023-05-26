package zerobase.weather.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemoRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo) {
        String sql = "insert into memo values(?,?)";
        jdbcTemplate.update(sql, memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll(){
        String sql = "select * from memo";
       return jdbcTemplate.query(sql, memoRowMapper()); // jdbcTemplate 이 mysql 데이터베이스에 가서 sql 쿼리문을 던지고, ResultSet 형태의 데이터를 Memo 객체로 가져옴
    }

    public Optional<Memo> findById(int id) {
        String sql = "select * from memo where id = ?";
        return jdbcTemplate.query(sql, memoRowMapper(), id).stream().findFirst();
        // optional 로 null 값을 쉽게 처리
    }

    private RowMapper<Memo> memoRowMapper() {
        // jdbc 를 통해서 DB 에서 데이터를 가져오면 ResultSet 의 데이터 형식이 됨
        // {id = 1, text = 'this is memo~'}
        // ResultSet 을 Memo 라는 형식으로 mapping 주는 걸 RowMapper
        return (rs, rowNum) -> new Memo(
                rs.getInt("id"),
                rs.getString("text")
        );

    }
}
