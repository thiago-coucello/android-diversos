package com.example.frases_do_dia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Frases extends AppCompatActivity {

    public Bundle parametro = new Bundle();

    public String[] frase_triste = {
            "Você é mais forte do que pensa e será mais feliz do que imagina.",
            "Se alguém tenta te derrubar, é porque não gosta do que você faz em pé.",
            "Se acalme, você só está passando por um momento ruim, mantenha o foco e a determinação que tudo dará certo.",
            "Dias bons vem para pessoas boas.",
            "Viver não é esperar a tempestade passar, é aprender a andar e se divertir na chuva.",
            "Você já passou por dias piores e conseguiu, o que está passando agora é só questão de tempo",
            "O tempo cura tudo.",
            "Tudo passa, o tempo passa, a vida passa, aproveite os poucos momentos que temos e transforme-os em momentos felizes.",
            "Coloque sua música preferida e mais animada e dance na frente do espelho.",
            "Faça uma atividade que te agrade.",
            "Se for possível, converse com quem te deixou triste."
    };

    public String[] frase_nervoso = {
            "Tome uma água, olhe o céu, faça algo que goste, e depois volte ao que estava fazendo.",
            "As vezes é preciso uma boa noite de sono ou um bom descanso antes de voltar a fazer algo.",
            "As vezes nem tudo sai como esperado, é necessário é respirar fundo e olhar em volta.",
            "Nem sempre temos o controle das coisas que estão acontecendo, se sentir frustrado é comum, mas se culpar por algo assim não.",
            "Toma um chazinho de cidreira.",
            "Busque apoio nos seus amigos, até o mais distante deles pode te ajudar de uma forma surpreendente."
    };

    public String[] frase_saudade = {
            "Mande mensagem praquela pessoa, as vezes abrir mão do orgulho vale mais a pena do que o risco de perder uma amizade.",
            "Certos momentos temos que ponderar se aquilo realmente nos faz bem, caso não o faça, deixe ir, é melhor para os dois lados.",
            "Antes de correr atrás de uma pessoa, reflita se essa pessoa faria o mesmo por você, relacionamentos unilaterais nunca são benéficos.",
            "Marque de se encontrar com a pessoa em mente, as vezes só é preciso um empurrãozinho."
    };

    public String[] frase_sozinho = {
            "Converse com seus pais sobre algo, algumas vezes eles são os melhores amigos que podemos ter",
            "Adotar um animalzinho pode tirar dois seres da solidão.",
            "Procure conversar com aqueles ao seu redor, muitas vezes bloqueamos outras pessoas inconscientementes.",
            "Ocupar a cabeça é uma ótima solução para vários problemas emocionais."
    };

    public String[] frase_qualquer = {
            "Dias bons vem para pessoas boas, você só não é a pessoa boa.",
            "Viver não é esperar a tempestade passar, é estar no olho do furacão tomando cházinho enquanto diz a si mesmo que não tem nada acontecendo.",
            "Tudo passa, o tempo passa, a vida passa, até uva passa",
            "Dormir e Comer, as pedras angulares para resolver tudo.",
            "Você não é insuficiente, só lhe falta ódio.",
            "Todos tem um momento que devem falar \"Hora de ligar o foda-se\""
    };

    public String[] frase_emily_triste = {
            "Amor, vai dar tudo certo, como eu disse não vou mais falar pra você não ficar triste, mas quero falar pra você ser forte, estou aqui pra você sempre que precisar.",
            "Não precisa se preocupar em me incomodar, eu sempre vou ter um tempo pra você, pra nós.",
            "Quero que você saiba que eu te amo muito, se eu puder ajudar de algum jeito, vou ajudar.",
            "Sempre que quiser, pode me pedir um abraço, um beijo, um carinho (menos pelo whatsapp, ai eu nem sei como te dar carinho), que eu vou ficar abraçado com você, do jeito que você mais gosta.",
            "Ei, você tira o melhor de mim, precisando de ajuda é só avisa.",
            "Vamos contruir nosso futuro em cima desses momentos complicados, sempre juntos.",
            "Deita na minha cama pra gente fazer idiotice juntos por favor.",
            "Calma amor, pensa em como vamos ser felizes no futuro.",
            "Eu e Você passando por isso juntos como o ótimo casal que somos, pode conversar comigo.",
            ""
    };

    public String[] frase_emily_qualquer = {
            "Eu sempre quis ter um relacionamento ocm alguém, mas nenhum dos 500 relacionamentos que eu imaginava chega aos pés do nosso, você deixou minha vida mais feliz de tantos jeitos.",
            "Ver você sorrindo aquece meu corpo e alegra minha alma de umas formas que você não faz ideia.",
            "Quando estamos juntos eu esqueço todos os meus problemas, dores e doenças, você é o meu remédio.",
            "Amo quando você dorme em mim, você parece tão tranquila e em paz, nem parece que com fome quase que me dá um tiro no primeiro ai que eu der.",
            "Acho engraçado quando você tem suas venetas, mas as vezes você consegue me machucar um pouco.",
            "Amo o jeito como a gente se entende, fazendo bobagens e sendo idiotas o tempo todo.",
            "Você me deixa animado pra fazer qualquer coisa.",
            "Adoro quando você vem aqui em casa pra fazermos altos nadas.",
            "Gosto de como você me elogia, apesar de eu ficar sem graça na maioria deles (Eu não sou metido).",
            "Amo tudo que você faz por mim.",
            "Amo o jeito como você me obriga a deitar no seu peito.",
            "Amo quando você atinge seus objetivos e conquistas. Parece que eu quem os atingi.",
            "Desculpa não ter músicas que me lembrem de você, mas olha o facebook, vão ter vários vídeos de animaizinhos.",
            "Ansioso pela nossa banheira, e nossa churrasqueira que vira um forno de pizza.",
            "Amo encher seu saco.",
            "Você é a melhor namorada que eu podia ter, me entende e me completa tão bem.",
            "Gosto de ver você focada.",
            "Planejo te fazer feliz mesmo quando todos as sua volta te fazem triste.",
            "Se o amor é pecado estou sentado no colo do diabo.",
            "Você faz com que a minha preguiça vá embora.",
            ""
    };

    public String[] frase_emily_nervosa = {
            "Ei, você é incrivel, não tem pra quê ficar nervosa, a maioria das pessoas não consegue fazer um décimo do que você consegue fazer.",
            "Vai se fuder mulher, perfeita do caralho.",
            "Me dá um abraço que vai dar tudo certo.",
            "Respira fundo e fica calma, você consegue tudo, é uma fêmea empoderada.",
            ""
    };

    public String[] frase_emily_sozinha = {
            "Sai dessa, você sabe que não está sozinha, manda mensagem pra mim, pras Anas, pro Judeu, pro Ludson, todas essas pessoas se importam com você, e eu mais ainda."
    };

    public String[] frase_emily_saudade = {
            "Tá esperando o que? Você sabe meu endereço, bora fazer alguma coisa (vários nadas é bom, porque eu não tenho dinheiro).",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        parametro = getIntent().getExtras();

        assert parametro != null;
        int opcao = parametro.getInt("opcao");
        int emily = parametro.getInt("chave_emily");

        if(emily == 0) {
            switch (opcao) {
                case 1: {
                    Frase_Triste();
                    break;
                }
                case 2: {
                    Frase_Nervoso();
                    break;
                }
                case 3: {
                    Frase();
                    break;
                }
                case 4: {
                    Frase_Saudade();
                    break;
                }
                case 5: {
                    Frase_Sozinho();
                    break;
                }
            }
        }
        else{
            switch (opcao) {
                case 1: {
                    Frase_TristeE();
                    break;
                }
                case 2: {
                    Frase_NervosoE();
                    break;
                }
                case 3: {
                    FraseE();
                    break;
                }
                case 4: {
                    Frase_SaudadeE();
                    break;
                }
                case 5: {
                    Frase_SozinhoE();
                    break;
                }
            }
        }

    }

    public void Retorno(View view){
        Intent retorno = new Intent(this, JogoNormal.class);

        retorno.putExtras(parametro);

        startActivity(retorno);
    }

    private void Frase_SozinhoE() {
        int frase = new Random().nextInt(frase_emily_sozinha.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_emily_sozinha[frase]);
    }

    private void Frase_SaudadeE() {
        int frase = new Random().nextInt(frase_emily_saudade.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_emily_saudade[frase]);
    }

    private void FraseE() {
        int frase = new Random().nextInt(frase_emily_qualquer.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_emily_qualquer[frase]);
    }

    private void Frase_NervosoE() {
        int frase = new Random().nextInt(frase_emily_nervosa.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_emily_nervosa[frase]);
    }

    private void Frase_TristeE() {
        int frase = new Random().nextInt(frase_emily_triste.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_emily_triste[frase]);
    }

    private void Frase_Sozinho() {
        int frase = new Random().nextInt(frase_sozinho.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_sozinho[frase]);
    }

    private void Frase_Saudade() {
        int frase = new Random().nextInt(frase_saudade.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_saudade[frase]);
    }

    private void Frase() {
        int frase = new Random().nextInt(frase_qualquer.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_qualquer[frase]);
    }

    private void Frase_Nervoso() {
        int frase = new Random().nextInt(frase_nervoso.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_nervoso[frase]);
    }

    private void Frase_Triste() {
        int frase = new Random().nextInt(frase_triste.length);

        TextView Frase = findViewById(R.id.frase);

        Frase.setText(frase_triste[frase]);
    }

}
