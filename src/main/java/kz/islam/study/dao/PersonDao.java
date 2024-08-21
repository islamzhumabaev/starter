package kz.islam.study.dao;

import kz.islam.study.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public Optional<Person> show(long iin) {
//            return jdbcTemplate.query(
//                    "SELECT * FROM people WHERE iin = ?",
//                    new Object[]{iin},
//                    new BeanPropertyRowMapper<>(Person.class)
//            ).stream().findAny();
//    }


    public Person show(String phone) {
        Object[] params = new Object[]{phone};
        List<Person> people = jdbcTemplate.query(
                "SELECT * FROM People WHERE phone=?",
                params,
                new BeanPropertyRowMapper<>(Person.class)
        );
        if (people.isEmpty()) {
            return null;
        } else {
            return people.get(0);
        }
    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO People (iin, name, surname, age, phone, gender, citizenship, email, accountnumber, salary, wallet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                person.getIin(), person.getName(), person.getSurname(), person.getAge(), person.getPhone(), person.getGender(), person.getCitizenship(), person.getEmail(), person.getAccountNumber(), person.getSalary(), person.getWallet());
    }
}
