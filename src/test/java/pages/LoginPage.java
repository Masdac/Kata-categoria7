package pages;

import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class LoginPage extends BasePage {
    private String usernameLocator = "//input[@name='username']";
    private String passwordLocator = "//input[@name='password']";
    private String loginButtonLocator = "//button[@type='submit']";
    private String errorMessageLocator = "//p[contains(@class,'oxd-alert-content-text')]";
    private String usernameErrorLocator = "//input[@name='username']/ancestor::div[contains(@class, 'oxd-input-group')]/following-sibling::span";
    private String passwordErrorLocator = "//input[@name='password']/ancestor::div[contains(@class, 'oxd-input-group')]/following-sibling::span";
    private String dashboardLocator = "//h6[text()='Dashboard']"; // Xpath del título en el Dashboard

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void abrirOrangehrm() {
        openPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void ingresarUsuario(String usuario) {
        writeTextBox(usernameLocator, usuario);
    }

    public void ingresarPassword(String password) {
        writeTextBox(passwordLocator, password);
    }

    public void clickLogin() {
        clickElement(loginButtonLocator);
    }

    public void verificarMensajeError(String mensajeEsperado) {
        assert find(errorMessageLocator).getText().equals(mensajeEsperado);
    }

    public void verificarMensajeErrorUsername(String mensajeEsperado) {
        assert find(usernameErrorLocator).getText().equals(mensajeEsperado);
    }

    public void verificarMensajeErrorPassword(String mensajeEsperado) {
        assert find(passwordErrorLocator).getText().equals(mensajeEsperado);
    }

    public void validarRedireccionDashboard() {
        assert find(dashboardLocator).isDisplayed();
    }

}
