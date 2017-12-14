package br.com.hellmets.motocerol;

import br.com.hellmets.motocerol.AndGraph.AGGameManager;
import br.com.hellmets.motocerol.AndGraph.AGInputManager;
import br.com.hellmets.motocerol.AndGraph.AGScene;
import br.com.hellmets.motocerol.AndGraph.AGScreenManager;
import br.com.hellmets.motocerol.AndGraph.AGSprite;
import br.com.hellmets.motocerol.AndGraph.AGTimer;
import br.com.hellmets.motocerol.AndGraph.AGSoundManager;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel Rodrigues on 07/12/2017.
 */

public class CampoDeJogo extends AGScene {

    //IMAGENS
    AGSprite imgCampoJogoFundo = null; //imagem do plano de fundo da cena Campo De Jogo
    AGSprite imgToupeira = null;
    AGSprite imgAcerto = null;

    //LISTAS
    ArrayList<AGSprite> listaToupeiras = null;

    //TEMPO
    AGTimer visivel = null;
    AGTimer invisivel = null;
    AGTimer tempoMaximo = null;

    //PONTUAÇÃO
    int toupeirasEsmagadas = 0;

    CampoDeJogo(AGGameManager manager){
        super(manager);
    }

    @Override
    public void init() { //Chamado toda vez que a cena Abertura é mostrada
        setSceneBackgroundColor(0,1,1);

        listaToupeiras = new ArrayList<AGSprite>();

        //BACKGROUD
        imgCampoJogoFundo = this.createSprite(R.mipmap.campo_jogo_fundo, 1, 1);
        imgCampoJogoFundo.setScreenPercent(100, 100); //Tamanho da imagem
        imgCampoJogoFundo.vrPosition.setXY (AGScreenManager.iScreenWidth/2, AGScreenManager.iScreenHeight/2);

        visivel = new AGTimer(500);
        invisivel = new AGTimer(550);
        tempoMaximo = new AGTimer(20000);
    }

    @Override
    public void restart() { //Volta a aplicação para onde parou quando foi chamado o método stop

    }

    @Override
    public void stop() { //Para a aplicação enquanto a aplicação passa para segundo plano

    }

    @Override
    public void loop() {
        criarToupeiras();
        atualizarToupeira();
        toupeiraInvisivel();
        esmagarToupeira();
        vitoria();
        derrota();
    }

    //GERAR TOUPEIRA NA TELA EM POSIÇÕES ALEATÓRIAS NO TEMPO DETERMINADO PELA VARIÁVEL visivel
    public void criarToupeiras (){

        visivel.update();

        for (AGSprite toupeira : listaToupeiras) {
            if (toupeira.bRecycled && toupeira.bVisible) {
                //DETERMINAR POSIÇÃO ALEATÓRIA
                toupeira.vrPosition.setXY(50 + (int) (Math.random() * (AGScreenManager.iScreenWidth - 50)), 50 + (int) (Math.random() * (AGScreenManager.iScreenHeight - 50)));
                toupeira.bRecycled = false;
                return;
            }
        }
        if (visivel.isTimeEnded()) {
            imgToupeira = createSprite(R.mipmap.img_toupeira_jogo, 1, 1);
            imgToupeira.setScreenPercent(25, 15);
            imgToupeira.vrPosition.setXY(50 + (int) (Math.random() * (AGScreenManager.iScreenWidth - 50)), 50 + (int) (Math.random() * (AGScreenManager.iScreenHeight - 50)));
            imgToupeira.bRecycled = false;
            listaToupeiras.add(imgToupeira);
            visivel.restart();
        }
    }

    public void atualizarToupeira(){
        for (AGSprite toupezeira : listaToupeiras){
            if (!toupezeira.bVisible){
                toupezeira.bRecycled = true;
            }
        }
    }

    //MUDA A TOUPEIRA DE VISÍVEL PARA INVISÍVEL NO TEMPO DETERMINADO PELA VARIÁVEL invisivel
    public void toupeiraInvisivel(){
        invisivel.update();
        for (AGSprite toupezeiras : listaToupeiras){
            if(invisivel.isTimeEnded() && toupezeiras.bVisible){
                toupezeiras.bVisible = false;
                invisivel.restart();
            }
        }
    }

    //VERIFICA SE O TOQUE NA TELA FOI NA TOUPERA PARA CONTABILIZAR PONTO.
    public  int esmagarToupeira(){
        for (AGSprite toupezeiras : listaToupeiras){
            if(AGInputManager.vrTouchEvents.screenClicked()){
                if(toupezeiras.collide(AGInputManager.vrTouchEvents.getLastPosition())){//SE O TOQUE FOI NA TOUPEIRA É CONTABILIZADO 1 PONTO
                    toupeirasEsmagadas++; //TOCOU NA TOUPEIRA +1 pto
                    toupezeiras.bVisible = false;
                    /*
                    imgAcerto = this.createSprite(R.mipmap.img_acerto, 1, 1);
                    imgAcerto.setScreenPercent(25, 15);
                    imgAcerto.addAnimation(20, false, 0, 15);
                    imgAcerto.vrPosition.setXY(toupezeiras.vrPosition.getX(), toupezeiras.vrPosition.getY());
                    */
                }
                /*
                if(imgCampoJogoFundo.collide(AGInputManager.vrTouchEvents.getLastPosition())){
                    toupeirasEsmagadas--; //TOCOU NO GRAMADO -1 pto
                }
                */
            }
        }
        return toupeirasEsmagadas; //RETORNA A QUANTIDADE DE TOUPEIRAS ESMAGADAS
    }

    //VERIFICAR SE A QUATIDADE DE TOUPEIRAS ESMAGADAS JÁ SÃO O SUFICIENTE PARA VENCER
    public void vitoria(){
        if(toupeirasEsmagadas > 7){
            AGSoundManager.vrMusic.loadMusic("vencedor.mp3", false);
            AGSoundManager.vrMusic.play();
            this.vrGameManager.setCurrentScene(3);
            toupeirasEsmagadas = 0;
            return;
        }
    }

    //VERIFICA SE O TEMPO MÁXIMO DE JOGO ENCERROU
    public void derrota(){
        tempoMaximo.update();
        if(tempoMaximo.isTimeEnded()){
            AGSoundManager.vrMusic.loadMusic("derrota.mp3", false);
            AGSoundManager.vrMusic.play();
            this.vrGameManager.setCurrentScene(4);
            toupeirasEsmagadas = 0;
            return;
        }
    }
}