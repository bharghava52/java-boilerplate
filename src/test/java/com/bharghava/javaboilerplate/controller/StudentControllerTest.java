package com.bharghava.javaboilerplate.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bharghava.javaboilerplate.entity.Student;
import com.bharghava.javaboilerplate.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = StudentController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void studentCreationTest() throws Exception {
        Student student = new Student(1, "Bharghava", "lastName");
        Mockito.when(studentService.addStudent(ArgumentMatchers.any())).thenReturn(student);
        ResultActions response = mockMvc.perform(
            MockMvcRequestBuilders.post("/student/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(student)));
        response.andExpect(MockMvcResultMatchers.status().isCreated());
        response.andExpect(MockMvcResultMatchers.jsonPath(
            "$.data.id", CoreMatchers.is(student.getId())));
        response.andExpect(MockMvcResultMatchers.jsonPath(
            "$.data.firstName", CoreMatchers.is(student.getFirstName())));
        response.andExpect(MockMvcResultMatchers.jsonPath(
            "$.data.lastName", CoreMatchers.is(student.getLastName())));
    }
    
}
