package kz.islam.study.controllers;

import kz.islam.study.dao.PersonDao;
import kz.islam.study.models.Person;
//import kz.islam.study.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonDao personDao;
//    private final PersonValidator personValidator;

    @Autowired
    public PersonController(PersonDao personDao ) {
        this.personDao = personDao;
//        this.personValidator = personValidator;
    }

    @GetMapping("/new")
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
//        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/new";
        }
        personDao.save(person);
        return "people/firstPage";
    }

    @GetMapping("/checkPhone")
    public String showCheckPhoneForm() {
        return "people/checkPhone";
    }

    @GetMapping("/check")
    public String checkPhone(@RequestParam("phoneNumber") String phone, Model model) {
        Person person = personDao.show(phone);
        if (person == null) {
            model.addAttribute("alert", "Person not found!");
            return "alert";
        }
        model.addAttribute("phone", phone);
        return "people/show";
    }
}
