package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BasePage;

import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void abrirOrangehrm() {
        openPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void ingresarUsuario(String usuario) {
        String usernameLocator = "//input[@name='username']";
        writeTextBox(usernameLocator, usuario);
    }

    public void ingresarPassword(String password) {
        String passwordLocator = "//input[@name='password']";
        writeTextBox(passwordLocator, password);
    }

    public void clickLogin() {
        String loginButtonLocator = "//button[@type='submit']";
        clickElement(loginButtonLocator);
    }

    public void verificarMensajeError(String mensajeEsperado) {
        String errorMessageLocator = "//p[contains(@class,'oxd-alert-content-text')]";
        Assert.assertEquals(find(errorMessageLocator).getText(), mensajeEsperado);
    }

    public void verificarMensajeRequiredUnElementoVacio(String mensajeEsperado) {
        String errorLocator = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";

        List<WebElement> errores = obtenerMensajesDeError(errorLocator);
        Assert.assertEquals(errores.size(), 1, "Se esperaba solo un mensaje de error, pero se encontraron: " + errores.size());

        String mensajeActual = errores.get(0).getText();

        Assert.assertEquals(mensajeActual, mensajeEsperado, "El mensaje de error no coincide con el esperado.");

    }

    public void verificarMensajeErrorDosElementosVacios(String mensajeEsperadoUsername, String mensajeEsperadoPassword) {
        String errorLocator = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
        List<WebElement> errores = obtenerMensajesDeError(errorLocator);
        Assert.assertEquals(errores.size(), 2, "Se esperaban dos mensajes de error, pero se encontraron: " + errores.size());

        String mensajeActualUsername = errores.get(0).getText();
        String mensajeActualPassword = errores.get(1).getText();

        Assert.assertEquals(mensajeActualUsername, mensajeEsperadoUsername, "El mensaje de Username no es el esperado.");
        Assert.assertEquals(mensajeActualPassword, mensajeEsperadoPassword, "El mensaje de Password no es el esperado.");
    }

    public void verificarMensajeErrorPassword(String mensajeEsperado) {
        String passwordErrorLocator = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";
        assert find(passwordErrorLocator).getText().equals(mensajeEsperado);
    }

    public void validarRedireccionDashboard() {
        String dashboardLocator = "//h6[text()='Dashboard']";
        assert find(dashboardLocator).isDisplayed();
    }

}
