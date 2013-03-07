package com.scarfilun.util;

import java.io.ByteArrayInputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.scarfilun.imagen.bo.ImagenBo;
import com.scarfilun.imagen.model.Imagen;

@SuppressWarnings("serial")
@ManagedBean(name="dynamicImageController")
@RequestScoped
public class DynamicImageController implements java.io.Serializable{

	@ManagedProperty(value = "#{imagenBo}")
	ImagenBo imagenBo;
	
	public DynamicImageController() {
	}
	
    public StreamedContent getGraphicText() {
    	
    	StreamedContent streamedContent =  new DefaultStreamedContent(); 
    	
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    	String imageID=externalContext.getRequestParameterMap().get("imageID");
    	if (imageID != null) {
    		byte[] foto = imagenBo.getFoto(Integer.parseInt(imageID));
    		streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(foto), "image/jpg");

    	}
    	return streamedContent;
    }

	public ImagenBo getImagenBo() {
		return imagenBo;
	}

	public void setImagenBo(ImagenBo imagenBo) {
		this.imagenBo = imagenBo;
	}
	
	public void handleFileUpload(FileUploadEvent event) {  

		byte[] foto = event.getFile().getContents();
		Imagen imagen = new Imagen();
		imagen.setFoto(foto);
		imagenBo.addFoto(imagen);
		
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
