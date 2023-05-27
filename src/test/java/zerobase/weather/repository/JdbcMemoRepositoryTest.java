package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
// 데이터베이스 테스트할 때 많이 사용하는 annotation -> test code 때문에 data 가 바뀌는 걸 막기위한 annotation
public class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        //given
        Memo newMemo = new Memo(2, "insertMemoTest");

        //when
        jdbcMemoRepository.save(newMemo);

        //then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText(), "insertMemoTest");
    }

    @Test
    void findAllMemoTest() {

        //when
        List<Memo> memoList = jdbcMemoRepository.findAll();

        //then
        System.out.println(memoList);
        assertNotNull(memoList);
    }
}
