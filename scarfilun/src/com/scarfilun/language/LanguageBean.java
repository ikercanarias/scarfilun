package com.scarfilun.language;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String localeCode = "es";

	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("Castellano", new Locale("es"));
		countries.put("English", Locale.ENGLISH); //label, value
	}

	public Map<String, Object> getCountriesInMap() {
		return countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public void countryLocaleCodeChanged(ValueChangeEvent e){

		String newLocaleValue = e.getNewValue().toString();

		//loop a map to compare the locale code
		for (Map.Entry<String, Object> entry : countries.entrySet()) {

			if(entry.getValue().toString().equals(newLocaleValue)){

				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
			}
		}
	}
}
