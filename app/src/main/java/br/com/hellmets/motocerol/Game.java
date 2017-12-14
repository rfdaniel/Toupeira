//Aplication package
package br.com.hellmets.motocerol;

//Used Packages
import android.os.Bundle;
import br.com.hellmets.motocerol.AndGraph.AGActivityGame;
import br.com.hellmets.motocerol.AndGraph.AGGameManager;


public class Game extends AGActivityGame
{
    public void onCreate(Bundle saved)
    {
        super.onCreate(saved);
        this.vrManager = new AGGameManager(this, false);

        Abertura a = new Abertura(vrManager); //Abertura a tem indice de cena 0
        vrManager.addScene(a); //Regitrando a cena a dentro do gerente de cenas

        CenaMenu cm = new CenaMenu(vrManager); //CenaMenu cm tem indice de cena 1
        vrManager.addScene(cm);

        CampoDeJogo cj = new CampoDeJogo(vrManager); //CampoDeJogo cj tem indice de cena 2
        vrManager.addScene(cj);

        CenaVitoria cv = new CenaVitoria(vrManager); //CenaVitoria cv tem indice de cena 3
        vrManager.addScene(cv);

        CenaDerrota cd = new CenaDerrota(vrManager); //CenaDerrota cd tem indice de cena 4
        vrManager.addScene(cd);

        SobreJogo sj = new SobreJogo(vrManager); //SobreJogo sj tem indice de cena 5
        vrManager.addScene(sj);

        AjudaJogo aj = new AjudaJogo(vrManager); //SobreJogo sj tem indice de cena 6
        vrManager.addScene(aj);
    }
}
