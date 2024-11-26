package com.luv2code.demo.dao;

import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinfetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);
    Course findCourseById(int theId);

    void deleteCourseById (int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);
}
