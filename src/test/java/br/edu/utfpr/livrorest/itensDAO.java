package br.edu.utfpr.livrorest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreendo
 */
public class itensDAO {
    List<itens> itens;
    
    //metodos que salvam e recuperam dados
    //de algum meio permanente (arquivos, banco de dados)    
     public itensDAO() {
        itens = new ArrayList<itens>();
        
        itens i = new itens();
        i.setItemId(50285046);
        i.setParentItemId(50285046);
        i.setNome("Celular Straight Talk iPhone 5S 16GB 4G LTE pré-pago");
        i.setMsrp(450);
        i.setSalePrice(149);
        i.setCategoryPath("Dan Brown");
        i.setUpc("190198051875");
        i.setLongDescription("Telemóveis / Telemóveis Straight Talk / Straight Talk");
        itens.add(i);
    }
     
    List<itens> getItens() {
        return itens;
    }
    
    itens getItens(long id) {
        for(itens l : itens)
            if(l.getItemId()== id)
                return l;
        
        return null;
    }

    void salvar(itens livro) {
        livro.setItemId((int) System.currentTimeMillis());
        //salvar no BD aqui
    }

    itens atualizar(long id, itens itens) {
        itens old = getItens(id);
        
        if(old == null)
        {
            itens t = new itens();
            t.setNome("id invalido");
            return t;
        }
        
        if(itens.getLongDescription()!= null && !itens.getLongDescription().equals(""))
            old.setLongDescription(itens.getLongDescription());
        
        return old;
    }

    String apagar(long id) {
        itens l = getItens(id);
        if(l == null)
            return "erro";
        
        return "livro " + id + " foi apagado";
    }
    
}
