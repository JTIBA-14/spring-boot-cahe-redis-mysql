package co.com.bancobogota;

import static org.junit.jupiter.api.Assertions.assertEquals;

import co.com.bancobogota.model.Location;
import co.com.bancobogota.service.ILocationService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/test-mysql.sql")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@CrossOrigin
public class LocationServiceTests {

    @Autowired
    ILocationService iLocationService;

    @Test
    @Order(1)
    void validateGetAllLocationSQL() {
        List<Location> locationsList;
        locationsList = iLocationService.listarTodos();
        assertEquals(3, locationsList.size());
    }

    @Test
    void validateSearchLocation() {
        Location locationData = iLocationService.listarPorId(1);

        assertEquals("Contabilidad", locationData.getName());
        assertEquals(24, locationData.getArea_m2());
    }

    @Test
    void validateCreateNewLocation() {
        Location locationData = new Location();
        locationData.setName("Administración");
        locationData.setArea_m2(30);
        locationData.setLocation(null);

        Location saveLocation = iLocationService.registrar(locationData);
        assertEquals("Administración", saveLocation.getName());
        assertEquals(30, saveLocation.getArea_m2());
    }

    @Test
    void validateUpdateLocation() {
        Location updateLocation = new Location();
        updateLocation.setId(1);
        updateLocation.setName("Contabilidad 2");
        updateLocation.setArea_m2(40);
        updateLocation.setLocation(null);

        Location saveLocation = iLocationService.registrar(updateLocation);
        assertEquals("Contabilidad 2", saveLocation.getName());
        assertEquals(40, saveLocation.getArea_m2());
    }

    @Test
    void validateDestroyLocationById() {
        assertEquals(true, iLocationService.eliminar(3));
    }

    @Test
    void errorSearchLocation() {
        Location location = new Location();
        Optional<Location> locationSearch = Optional.of(location);
        locationSearch = Optional.ofNullable(iLocationService.listarPorId(4));
        assertEquals(Optional.empty(), locationSearch);
    }

    @Test
    void validateErrorDestroyLocation() {
        int id = 8;
        System.out.println(iLocationService.eliminar(id));
        //assertEquals( false, iLocationService.eliminar(id));
    }


}
