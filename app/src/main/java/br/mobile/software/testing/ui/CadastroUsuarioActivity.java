package br.mobile.software.testing.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import br.mobile.software.testing.R;
import br.mobile.software.testing.repository.Repositorio;
import br.mobile.software.testing.entity.Usuario;

public class CadastroUsuarioActivity extends AppCompatActivity {


    private EditText login, senha, senha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        login = findViewById(R.id.login_input);
        senha = findViewById(R.id.senha_input);
        senha2 = findViewById(R.id.senha2_input);

        findViewById(R.id.btn_cadastrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String userName = login.getText().toString().trim();
        String password = senha.getText().toString().trim();
        String password2 = senha2.getText().toString().trim();

        if (userName.isEmpty()) {
            login.setError("Informe o nome de usuário");
            login.requestFocus();
            return;
        } else {
            if (password.isEmpty()) {
                senha.setError("Informe uma senha");
                senha.requestFocus();
                return;
            }
            if (password2.isEmpty()) {
                senha2.setError("Repita a senha");
                senha2.requestFocus();
                return;
            }
            if (!password.equals(password2)){
                senha2.setError("As senhas devem ser iguais");
                senha2.requestFocus();
                return;
            }
        }
        Repositorio.cadastraUsuario(new Usuario(userName, password));
        finish();
    }

}
