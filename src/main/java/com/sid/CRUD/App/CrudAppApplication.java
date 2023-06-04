package com.sid.CRUD.App;

import com.sid.CRUD.App.service.CrudappService;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Crudapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RequestMapping("/persons")
@RestController
public class CrudAppApplication {

	@Autowired
	private CrudappService service;

	@PostMapping
	public String add(@RequestBody Crudapp person) {
		service.insert(person);
		return "person added";
	}

	@GetMapping
	public List<Crudapp> read() {
		return service.read();
	}

	public String update(@RequestBody String name, int age) {
		service.update(name, age);
		return "age updated";
	}

	public String delete(@RequestBody String name) {
		service.delete(name);
		return "person deleted";
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

}
