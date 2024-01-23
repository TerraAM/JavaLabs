package org.openjfx.mycriptofx;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MyPaneGr {
    BorderPane border;
    
    MyPaneGr(){
        border = new BorderPane();
        border.setLeft(addVBox());
    }
    
    private VBox addVBox(){
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(10);
        Text text = new Text ("Введите текст");
        Text text1 = new Text ("хеш вашего текста. В таком виде, например, пароль может храниться в БД");
        Text text2 = new Text ("код для аутентификации Вашего текста. Позваоляет проверить его подлинность");
        Text text3 = new Text ("секретный ключи. Ваш зашифрованный/расшифрованный текст");
        Text text4 = new Text ("открытый/закрытый ключ. Ваш зашифрованный/расшифрованный текст");
        Text text5 = new Text ("электронная подпись. Сигнатура подписи и ее аутентификация");
        TextArea textInput = getTextArea(true);
        TextArea textOutput1 = getTextArea(false);
        TextArea textOutput2 = getTextArea(false);
        TextArea textOutput3 = getTextArea(false);
        TextArea textOutput4 = getTextArea(false);
        TextArea textOutput5 = getTextArea(false);
        Button btn = new Button("Get Cripto");
        btn.setPrefSize(150,20);
        vbox.getChildren().addAll(text,textInput,text1,textOutput1,text2,textOutput2,
                text3,textOutput3,text4,textOutput4,text5,textOutput5,btn);
        btn.setOnAction((ActionEvent event)->{
            if (!textInput.getText().equals("")){
                try{
                    textOutput1.setText(MyCripto.getHashString(textInput.getText()));
                    textOutput2.setText(MyCripto.getMacString(textInput.getText()));
                    textOutput3.setText(MyCripto.getCipherString(textInput.getText()));
                    textOutput4.setText(MyCripto.getPairCipherString(textInput.getText()));
                    textOutput5.setText(MyCripto.getElectSigmatString(textInput.getText()));
                } catch(Exception ex){
                    System.err.print(MyPaneGr.class.getName());
                }
            }
        });
        return vbox;   
    }
    private TextArea getTextArea(boolean isEditable){
        TextArea textOutput = new TextArea();
        textOutput.setPrefColumnCount(60);
        textOutput.setPrefRowCount(2);
        textOutput.setEditable(isEditable);
        return textOutput;
    }
}
