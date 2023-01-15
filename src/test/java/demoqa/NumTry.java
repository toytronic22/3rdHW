package demoqa;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class NumTry extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {
        String firstName = "Alexey";
        String lastName = "Martynov";
        String fullName = firstName + " " + lastName;
        String userEmail = "leshaklew@gmail.com";
        String gender = "Male";
        String userNumber = "9604613587";
        String birthYear = "1989";
        String birthMonth = "May";
        String birthDay = "18";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String subject1 = "Arts";
        String subject2 = "Physics";
        String subjects = subject1 + ", " + subject2;
        String hobby1 = "Music";
        String hobby2 = "Reading";
        String hobbies = hobby1 + ", " + hobby2;
        String img = "eric.png";
        String currentAddress = "My place";
        String state = "NCR";
        String city = "Delhi";
        String stateAndCity = state + " " + city;
//
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .setPicture(img)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();
//
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", fullName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDate)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", stateAndCity);
    }
}