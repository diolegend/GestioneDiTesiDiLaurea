package domainModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import utils.Console;
import utils.Pair;

public class AppelloTesi {
	
	private int id;
	private String date;
	private Pair<Integer, String> aula;
	private String startTime;
	private String linkTeleconferenza;
	private String nota;
	
	public AppelloTesi(int idAppello, String data, String startTime, Pair<Integer, String> aula, String linkTeleconferenza, String nota) {
		this.id = idAppello;
		this.date = data;
		this.startTime = startTime;
		this.aula = aula;
		this.linkTeleconferenza = linkTeleconferenza;
		this.nota = nota;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateString() {
		
		
		if (date == null)
			return "INDEFINITO";
		else {
			Console.print("(getDateString) " + date, date);
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return new String(LocalDate.parse(date, formatter).format(formatter2));
		}
	}
	
	public String getData() {
		return date;
	}

	public void setData(String data) {
		this.date = date;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String informazione) {
		this.nota = informazione;
	}

	public Pair<Integer, String> getAula() {
		return aula;
	}

	public void setAula(Pair<Integer, String> aula) {
		this.aula = aula;
	}

	public String getStartTime() {
		return getStartTimeString();
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getStartTimeString() {
		if(startTime != null) {
			return new String(startTime);
		}else {
			return new String("");
		}
	}

	public String getLinkTeleconferenza() {
		return linkTeleconferenza;
	}

	public void setLinkTeleconferenza(String linkTeleconferenza) {
		this.linkTeleconferenza = linkTeleconferenza;
	}
}
