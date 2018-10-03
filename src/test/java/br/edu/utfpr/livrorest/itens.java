package br.edu.utfpr.livrorest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andreendo
 */
@XmlRootElement
public class itens {
    int itemId, parentItemId, msrp;
    String nome, categoryPath, longDescription, upc;
    double salePrice;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    public int getMsrp() {
        return msrp;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(nome);
        sb.append(",");
        sb.append(categoryPath);
        sb.append(",");
        sb.append(longDescription);
        sb.append(",");
        sb.append(itemId);
        sb.append(",");
        sb.append(parentItemId);
        sb.append(",");
        sb.append(msrp);
        sb.append(",");
        sb.append(upc);
        sb.append(",");
        sb.append(salePrice);
        return sb.toString();
    }
}
