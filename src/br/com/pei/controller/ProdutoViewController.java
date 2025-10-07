package br.com.pei.controller;

import br.com.pei.dao.ProdutoDAO;
import br.com.pei.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert; // IMPORTAR ALERT
import javafx.scene.control.Alert.AlertType; // IMPORTAR ALERTTYPE
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProdutoViewController {

    @FXML private TextField codigoField;
    @FXML private TextField nomeField;
    @FXML private TextArea descricaoArea;
    @FXML private TextField precoField;
    @FXML private TextField quantidadeField;
    @FXML private Button salvarButton;
    @FXML private Button cancelarButton;

    @FXML
    public void onSalvarAction() {
        // Validação de campos vazios (exemplo básico)
        if (codigoField.getText().isEmpty() || nomeField.getText().isEmpty() || precoField.getText().isEmpty() || quantidadeField.getText().isEmpty()) {
            showAlert("Erro de Validação", "Todos os campos devem ser preenchidos.");
            return; // Interrompe a execução do método
        }
    
        String codigo = codigoField.getText();
        String nome = nomeField.getText();
        String descricao = descricaoArea.getText();
    
        try {
            double preco = Double.parseDouble(precoField.getText().replace(",", ".")); // Aceita vírgula ou ponto
            int quantidade = Integer.parseInt(quantidadeField.getText());
            
            Produto novoProduto = new Produto(codigo, nome, preco, quantidade, descricao);
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.save(novoProduto);
            
            showAlert("Sucesso", "Produto salvo com sucesso!");
            
            fecharJanela();

        } catch (NumberFormatException e) {
            // MELHORIA: Mostrar um alerta visual em vez de imprimir no console
            showAlert("Erro de Formato", "Os campos 'Preço' e 'Quantidade' devem ser números válidos.");
        }
    }
    
    // CORREÇÃO 1: Implementando o método onCancelarAction
    @FXML
    public void onCancelarAction() {
        fecharJanela();
    }
    
    // CORREÇÃO 1: Implementando o método fecharJanela
    private void fecharJanela() {
        // Pega a referência do Stage (Janela) a partir de qualquer componente, como o botão Cancelar
        Stage stage = (Stage) cancelarButton.getScene().getWindow();
        stage.close();
    }
    
    // MÉTODO AUXILIAR PARA MOSTRAR ALERTAS
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION); // Você pode usar AlertType.ERROR para erros
        if(title.toLowerCase().contains("erro")){
             alert.setAlertType(AlertType.ERROR);
        }
        alert.setTitle(title);
        alert.setHeaderText(null); // Sem cabeçalho
        alert.setContentText(message);
        alert.showAndWait();
    }
}