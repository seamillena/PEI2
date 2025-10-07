package br.com.pei.controller; // Garanta que o pacote está correto

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController {

    // Este é o método que será chamado pelo onAction do menu
    public void onMenuItemProdutoAction() {
        System.out.println("Clicou no menu Produto!"); // Teste para ver no console

        try {
            // Carrega a tela de produtos (que vamos criar)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ProdutoView.fxml"));
            Parent root = loader.load();

            // Cria uma nova janela (Stage) para a tela de produtos
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Produto");
            stage.setScene(new Scene(root));

            // Bloqueia a janela principal enquanto a de cadastro estiver aberta
            stage.initModality(Modality.APPLICATION_MODAL);

            // Mostra a janela e espera ela ser fechada
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}