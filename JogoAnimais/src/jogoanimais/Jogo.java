/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoanimais;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Jogo {
    
    private ArrayList<GrupoAnimais> grupoAnimais;

    public Jogo() 
    {
        grupoAnimais = new ArrayList();
        
        grupoAnimais.add(new GrupoAnimais("tem garras", new Animal("Leão")));
    }
    
    private void inicar()
    {
        JOptionPane.showMessageDialog(null, "Jogo dos Animais!!!");
    }
    
    private void finalizar()
    {
        JOptionPane.showMessageDialog(null, "Obrigado por Jogar!!!");
    }
    
    private void pense()
    {
        JOptionPane.showMessageDialog(null, "Pense em um Animal!!!");
    }
    
    private void perguntaSis(GrupoAnimais gAnimais, int indexGrupo)
    {
        //Pergunta se pertence ao grupo.
        int resp = JOptionPane.showConfirmDialog(null, "O animal que você pensou "+gAnimais.getNomeGrupo()+ "?","",JOptionPane.YES_NO_OPTION);
        
        //Se fizer.
        if(resp == JOptionPane.YES_OPTION)
        {
            int respFinal = -1;
            int indexAnimal = 0;
            
            //Pergunta se é um dos animais do grupo.
            //Se for um dos animais ou nenhum o loop acaba.
            while(indexAnimal < gAnimais.getListAnimais().size() && respFinal != JOptionPane.YES_OPTION)
            {
                respFinal = JOptionPane.showConfirmDialog(null, "O animal que você pensou foi: "+gAnimais.getListAnimais().get(indexAnimal++),"",JOptionPane.YES_NO_OPTION);
            }
            
            //Se não for ele pergunta que animal que foi pensado e add a lista de animais do grupo.
            if(respFinal == JOptionPane.NO_OPTION)
            {
                nomeAnimal(0, indexGrupo);
            } 
        }
        //Se não pertence ao grupo.
        else
            //Chama recursico o próximo grupo se tiver.
            if(indexGrupo < grupoAnimais.size()-1)
                perguntaSis(grupoAnimais.get(++indexGrupo),indexGrupo);
            //Se não pergunta qual animal.
            else
            {
                nomeAnimal(1, indexGrupo);
            }
    }

    public void jogar() 
    {
        inicar();

        int resp;
        do
        {
            //Msg - Pense em um Animal!!!
            pense();
            
            //MsgOp - O animal que você pensou X
            perguntaSis(grupoAnimais.get(0),0);
            
            //Pergunta se deseja continuar jogando.
            resp = JOptionPane.showConfirmDialog(null, "Continuar jogando?","",JOptionPane.YES_NO_OPTION);
        }while(resp == JOptionPane.YES_OPTION);
        
        finalizar();
    }
    
    public void nomeAnimal(int op, int indexGrupo)
    {
        String nomeAnimal = JOptionPane.showInputDialog("Qual animal você pensou?");
        
        //Validação se digitou algo válido
        if(nomeAnimal != null && !nomeAnimal.trim().equals(""))
        {
            //Op = 0 add mesmo grupo
            //Op = 1 add novo grupo
            if(op == 1)
            {
                String nomeGrupo = JOptionPane.showInputDialog("Um(a) "+nomeAnimal+" ________ mas um(a) "+grupoAnimais.get(indexGrupo).getListAnimais().get(grupoAnimais.get(indexGrupo).getListAnimais().size()-1)+" não.");
            
                //Cria grupo e já add animal
                grupoAnimais.add(new GrupoAnimais(nomeGrupo, new Animal(nomeAnimal)));
            }
            else
                //Add animal no grupo já existente.
                grupoAnimais.get(indexGrupo).getListAnimais().add(new Animal(nomeAnimal));
        } 
    }
}
