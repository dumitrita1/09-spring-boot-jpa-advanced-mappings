package com.luv2code.demo;

import com.luv2code.demo.dao.AppDAO;
import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
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
