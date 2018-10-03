package br.edu.utfpr.livrorest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("itens")
public class itensResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<itens> getTodosItens() {
        System.out.println("GET all");
        itensDAO dao = new itensDAO();
        return dao.getItens();
    }
    
    @Path("{idItens}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public itens getLivroById(@PathParam("idItens") long id) {
        System.out.println("GET id");
        itensDAO dao = new itensDAO();
        return dao.getItens(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public itens addItens(itens i) {
        System.out.println("POST " + i);
        itensDAO dao = new itensDAO();
        dao.salvar(i);
        
        return i;
    }

    @Path("{idItens}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public itens atualizar(@PathParam("idItens") long id, itens i) {
        System.out.println("PUT " + i);
        itensDAO dao = new itensDAO();
        return dao.atualizar(id, i);
    }

    @Path("{idItens}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String apagar(@PathParam("idItens") long id) {
        System.out.println("DELETE " + id);
        itensDAO dao = new itensDAO();
        return dao.apagar(id);
    }
}
