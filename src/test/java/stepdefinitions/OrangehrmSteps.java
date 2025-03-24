package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class OrangehrmSteps {
    WebDriver driver = Hooks.getDriver(); // Se obtiene el WebDriver desde Hooks
    LoginPage loginPage = new LoginPage(driver); // Se usa en la Page Object

    @Given("el usuario escribe {string} en username")
    public void escribirUsuario(String usuario) {
        loginPage.abrirOrangehrm();
        loginPage.ingresarUsuario(usuario);
    }

    @Given("el usuario escribe en el campo {string} el texto {string}")
    public void escribirCampo(String usuario, String texto) {
        loginPage.abrirOrangehrm();
        ingresarCampo(usuario, texto);
    }

    @Given("el usuario deja vacio el username y el password")
    public void dejarVaciosCampos() {
        loginPage.abrirOrangehrm();
        loginPage.ingresarUsuario("");
        loginPage.ingresarPassword("");
    }

    @And("escribe en el campo {string} el texto {string}")
    public void escribirMensaje(String usuario, String texto) {
        ingresarCampo(usuario, texto);
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

    @Then("se muestra 1 mensaje {string} en la pantalla")
    public void validarMensajeError(String mensajeEsperado) {
        loginPage.verificarMensajeRequiredUnElementoVacio(mensajeEsperado);
    }

    @Then("se muestra 2 mensajes {string} en la pantalla")
    public void validarDosMensajeError(String mensajeEsperado) {
        loginPage.verificarMensajeErrorDosElementosVacios(mensajeEsperado, mensajeEsperado);
    }

    @Then("se muestra el mensaje {string} en el campo password")
    public void validarMensajePassword(String mensajeEsperado) {
        loginPage.verificarMensajeErrorPassword(mensajeEsperado);
    }

    @Then("el usuario es redirigido al dashboard")
    public void validarRedireccionDashboard() {
        loginPage.validarRedireccionDashboard();
    }

    private void ingresarCampo(String campo, String texto) {
        switch (campo) {
            case "username":
                loginPage.ingresarUsuario(texto);
                break;
            case "password":
                loginPage.ingresarPassword(texto);
                break;
            default:
                throw new IllegalArgumentException("Campo desconocido: " + campo);
        }
    }

}
