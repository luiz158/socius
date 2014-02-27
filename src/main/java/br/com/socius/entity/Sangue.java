package br.com.socius.entity;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Sangue {

	A_POSITIVE("A+"), A_NEGATIVE("A-"), B_POSITIVE("A+"), B_NEGATIVE("B-"), 
	AB_POSITIVE("AB+"), AB_NEGATIVE("AB-"), O_POSITIVE("O+"), O_NEGATIVE("O-");

	private final String value;

	Sangue(String value) {
		this.value = value;
	}

	@JsonValue
	public String toString() {
		return this.value.replaceAll("_POSITIVE", "+").replaceAll("_NEGATIVE","-");
	}

	@JsonCreator
	public static Sangue fromValue(String value) {
		Sangue result = null;

		for (Sangue sexo : values()) {
			if (sexo.toString().equalsIgnoreCase(value)) {
				result = sexo;
				break;
			}
		}

		return result;
	}
}
