package com.luv2code.demo;

import com.luv2code.demo.dao.AppDAO;
import com.luv2code.demo.entity.Course;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return runner -> {

			//createCourseAndReviews(appDAO);
			//retrieveCourseAndReviews(appDAO);
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId =10;
		System.out.println("Deletng course in: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId =10;
		Course tempCourse =appDAO.findCourseAndReviewsByCourseId(theId);
		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReview());
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse =new Course("Pacman -How to score One Milion Points");

		// add some reviews
		tempCourse.addReview(new Review("Great course ---- love it"));
		tempCourse.addReview(new Review("Cool course ---- great job"));
		tempCourse.addReview(new Review("You are an idiot"));

		// save the course
		System.out.println("Saving the course ");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReview());
		appDAO.save(tempCourse);
		System.out.println("Done");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("deleteing corse id: " +theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId=10;
		//find the course

		System.out.println("Finding course id: " +theId);
		Course tempCourse =appDAO.findCourseById(theId);

		System.out.println("Updating instructor id: " +theId);
		tempCourse.setTitle("Enjoy the Simple things");
		appDAO.update(tempCourse);
		System.out.println("DONE");
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId=1;
		//find the instructor

		System.out.println("Finding Instructor id: " +theId);
		Instructor tempInstructor =appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id: " +theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);
		System.out.println("DONE");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id: " +theId);
		Instructor tempInstructor =appDAO.findInstructorByIdJoinfetch(theId);
		System.out.println("tempInstructor" +tempInstructor);
		System.out.println("the associated courses" + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " +theId);
		Instructor tempInstructor =appDAO.findInstructorById(theId);
		System.out.println("tempInstructor" +tempInstructor);

		// find courses for Instruction
		System.out.println("Finding Coursses for instructor id: " +theId);
		List<Course> courses =appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses" +tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " +theId);
		Instructor tempInstructor =appDAO.findInstructorById(theId);
		System.out.println("tempInstructor" +tempInstructor);
		System.out.println("the associated coursses" + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor=
				new Instructor("sussan", "Public", "susan@gmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games!!"
				);
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1 = new Course("Air Guitar");
		Course tempCoursel2 = new Course("the Pinball");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCoursel2);

		System.out.println("saving instructor: " +tempInstructor);
		System.out.println("the courses: " +tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId =3;
		System.out.println("deleting instructor " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 2;
		System.out.println("finding instructor detail id: " + theId);

		InstructorDetail tempInstructorDetail =appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " +tempInstructorDetail);
		System.out.println("the associate instructor Detail only:" + tempInstructorDetail.getInstructor());


	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId =1;
		System.out.println("deleting instructor " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("finding instructor id: " + theId);

		Instructor tempInstructor =appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " +tempInstructor);
		System.out.println("the associate instructor Detail only:" + tempInstructor.getInstructorDetail());
		System.out.println("DONE!")
;	}

	private void createInstructor(AppDAO appDAO) {
/*
		Instructor tempInstructor=
				new Instructor("dumi", "Gorgan", "dumi@gmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code !!"
			);

 */

		Instructor tempInstructor=
				new Instructor("Matthias", "Muller", "Matthias@gmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitler!!"
				);
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving Instructor" +tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
