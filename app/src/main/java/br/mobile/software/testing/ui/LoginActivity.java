package br.mobile.software.testing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.mobile.software.testing.R;
import br.mobile.software.testing.repository.Repositorio;
import br.mobile.software.testing.entity.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText login, senha;
    private TextView mensagemErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_input);
        senha = findViewById(R.id.senha_input);
        mensagemErro = findViewById(R.id.textview_mensagem_erro);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        findViewById(R.id.link_cadastrar_usuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, CadastroUsuarioActivity.class));
            }
        });
    }

    private void loginUser() {
        final String userName = login.getText().toString().trim();
        String password = senha.getText().toString().trim();

        if (userName.isEmpty()) {
            login.setError("Informe o nome de usuário");
            login.requestFocus();
            return;
        } else if (password.isEmpty()) {
            senha.setError("Informe a senha");
            senha.requestFocus();
            return;
        }
        Usuario usuarioLogado = Repositorio.get(userName, password);
        if(usuarioLogado!=null){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }else{

            mensagemErro.setText("Usuário e/ou senha inválidos");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mensagemErro.setText("");
    }
}
