//package kz.islam.study.util;
//
//import kz.islam.study.dao.PersonDao;
//import kz.islam.study.models.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component
//public class PersonValidator implements Validator {
//
//    private final PersonDao personDao;
//
//    @Autowired
//    public PersonValidator(PersonDao personDao) {
//        this.personDao = personDao;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Person.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//
//        if (personDao.show(Long.parseLong(person.getIin())).isPresent()) {
//            errors.rejectValue("iin", "", "IIN is already in use");
//        }
//        //посмотреть есть ли в БД человек в таким email
//    }
//}
