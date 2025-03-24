package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class OrangehrmSteps {
    WebDriver driver = Hooks.getDriver(); // Se obtiene el WebDriver desde Hooks
    LoginPage loginPage = new LoginPage(driver); // Se usa en la Page Object

    @Given("el usuario escribe {string} en username")
    public void escribirUsuario(String usuario) {
        loginPage.abrirOrangehrm();
        loginPage.ingresarUsuario(usuario);
    }

    @Given("el usuario deja vacío el campo username")
    public void dejarVacioUsername() {
        loginPage.abrirOrangehrm();
        loginPage.ingresarUsuario(""); // Enviamos una cadena vacía
    }

    @Given("el usuario deja vacío el campo password")
    public void dejarVacioPassword() {
        loginPage.ingresarPassword(""); // Enviamos una cadena vacía
    }

    @And("escribe {string} en password")
    public void escribirPassword(String password) {
        loginPage.ingresarPassword(password);
    }

    @When("se da click al botón Login")
    public void clicEnLogin() {
        loginPage.clickLogin();
    }

    @Then("se muestra el mensaje {string}")
    public void validarMensaje(String mensajeEsperado) {
        loginPage.verificarMensajeError(mensajeEsperado);
    }

    @Then("se muestra el mensaje {string} en el campo username")
    public void validarMensajeUsername(String mensajeEsperado) {
        loginPage.verificarMensajeErrorUsername(mensajeEsperado);
    }

    @Then("se muestra el mensaje {string} en el campo password")
    public void validarMensajePassword(String mensajeEsperado) {
        loginPage.verificarMensajeErrorPassword(mensajeEsperado);
    }

    @Then("el usuario es redirigido al dashboard")
    public void validarRedireccionDashboard() {
        loginPage.validarRedireccionDashboard();
    }

}
