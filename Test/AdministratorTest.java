import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdministratorTest {

    @Test
    void totalMemberShipIncomeForTest() throws FileNotFoundException {


        Administrator administrator = new Administrator();

        //Arrange
        int expected = 1000;

        //Act
        int actual = administrator.totalMemberShipIncomeForTest(1000);

        //Assert
        assertEquals(expected , actual);


    }

}