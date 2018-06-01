package exercicios;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Datas {
	
	public static void main(String[] args) {
		
		// Criando Objetos de data
		LocalTime horaCorrente = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime agora = LocalDateTime.now();
		
		System.out.println(horaCorrente);
		System.out.println(hoje);
		System.out.println(agora);
		
		System.out.println("**** FUSO HORÁRIO ******");
		
		// FUSO HORÁRIO
		LocalTime time = LocalTime.now(ZoneId.of("America/Chicago")); 
		LocalDate date = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("NST")));
		LocalDateTime dateTime =  LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		
		System.out.println(time);
		System.out.println(date);
		System.out.println(dateTime);
		
		System.out.println("**** REPRESENTAÇÃO DE DATAS ATRAVÉS DE OF ******");
		
		// REPRESENTAÇÃO DE DATAS ATRAVÉS DE OF
		LocalDate christmas2014 = LocalDate.of(2014, 12, 25);
		LocalDate christmas2015 = LocalDate.of(2015, Month.DECEMBER, 25);
		
		System.out.println(christmas2014);
		System.out.println(christmas2015);
		
		LocalDateTime christmasAtNoon = LocalDateTime.of(christmas2014, LocalTime.of(12, 0));
		
		System.out.println(christmasAtNoon);
		
		System.out.println("**** EXTRAINDO PARTES DE UMA DATA ******");
		
		//Extraindo partes de uma data
		LocalDateTime now = LocalDateTime.of(2014,12,15,13,0);
		System.out.println(now.getDayOfMonth()); // 15
		System.out.println(now.getDayOfYear());  // 349
		System.out.println(now.getHour());       // 13
		System.out.println(now.getMinute());     // 0
		System.out.println(now.getYear());       // 2014
		System.out.println(now.getDayOfWeek());  // MONDAY
		System.out.println(now.getMonthValue()); // 12
		System.out.println(now.getMonth());      // DECEMBER
		
		LocalDateTime born = LocalDateTime.of(1982,3,24,17,55);
		System.out.println(born.get(ChronoField.DAY_OF_MONTH));  
		System.out.println(born.get(ChronoField.DAY_OF_YEAR));
		System.out.println(born.get(ChronoField.HOUR_OF_DAY));  
		System.out.println(born.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println(born.get(ChronoField.YEAR));   
		System.out.println(born.get(ChronoField.DAY_OF_WEEK));    
		System.out.println(born.get(ChronoField.MONTH_OF_YEAR));
		
		System.out.println("**** COMPARAÇÕES ENTRE DATAS ******");
		
		//Comparações entre datas
		MonthDay day1 = MonthDay.of(1, 1); //01/jan
		MonthDay day2 = MonthDay.of(1, 2); //02/jan

		System.out.println(day1.isAfter(day2)); //false
		System.out.println(day1.isBefore(day2)); //true
		
		LocalDate aprilFools = LocalDate.of(2015, 4, 1);
		LocalDate foolsDay = LocalDate.of(2015, 4, 1);
		System.out.println(aprilFools.isEqual(foolsDay));
		System.out.println(aprilFools.isSupported(ChronoField.DAY_OF_MONTH)); 
		System.out.println(aprilFools.isSupported(ChronoField.HOUR_OF_DAY));
		System.out.println(aprilFools.isSupported(ChronoUnit.DAYS)); 
		System.out.println(aprilFools.isSupported(ChronoUnit.HOURS)); 
		
		System.out.println("**** ALTERAÇÃO DE DATAS ******");
		
		//Alteração de datas
		LocalDate d = LocalDate.of(2015, 4, 1); //2014-04-01

		d = d.withDayOfMonth(15).withMonth(3); //chaining
		System.out.println(d); //2015-03-15
		
		LocalDate d1 = LocalDate.of(2013, 9, 7);
		System.out.println(d1); // 2013-09-07
		d1.withMonth(12);
		System.out.println(d1); // 2013-09-07
		
		LocalDate d2 = LocalDate.of(2013, 9, 7);
		d2 = d2.plusDays(1).plusMonths(3).minusYears(2);
		System.out.println(d2); // 2011-12-08
		
		LocalDate d3 = LocalDate.of(2013, 9, 7);
		d3 = d3.plusWeeks(3).minus(3, ChronoUnit.WEEKS);
		System.out.println(d3);
		
		System.out.println("**** CONVERTENDO ENTRE TIPOS ******");
		
		//Convertendo entre os diversos tipos de datas
		now = LocalDateTime.now();
		LocalDate dateNow = now.toLocalDate(); // de DateTime para Date
		LocalTime timeNow = now.toLocalTime(); // de DateTime para Time
		System.out.println(now);
		System.out.println(dateNow);
		System.out.println(timeNow);
		
		// de Date para DateTime
		LocalDateTime nowAtTime1 = dateNow.atTime(timeNow); 
		// de Time para DateTime
		LocalDateTime nowAtTime2 = timeNow.atDate(dateNow);
		System.out.println(nowAtTime1);
		System.out.println(nowAtTime2);
		
		System.out.println("**** API LEGADAS ******");
		
		//Trabalhando com a API legada
		Date d5 = new Date();
		Instant i = d5.toInstant();
		LocalDateTime ldt1 = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
		System.out.println(ldt1);
		
		Calendar c = Calendar.getInstance();
		i = c.toInstant();
		LocalDateTime ldt2 = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
		System.out.println(ldt2);
		
		i = ldt1.toInstant(ZoneOffset.UTC);
		d5 = Date.from(i);
		System.out.println(d5);
		
		System.out.println("**** CALCULO COM DATAS ******");
		
		//Cálculos de intervalo de tempo com datas
		Instant instant = Instant.now(); // agora
		System.out.println(instant);
		Duration tenSeconds = Duration.ofSeconds(10); 
		Instant t = instant.plus(tenSeconds); 
		System.out.println(t);
		
		Instant t1 = Instant.EPOCH; // 01/01/1970 00:00:00
		Instant t2 = Instant.now();
		long secondsSinceEpoch = Duration.between(t1, t2).getSeconds();
		System.out.println(secondsSinceEpoch);
		
		LocalDate birthday = LocalDate.of(1982, 03, 24);
		LocalDate base = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthday, base)); 
		System.out.println(ChronoUnit.MONTHS.between(birthday, base)); 
		System.out.println(ChronoUnit.DAYS.between(birthday, base));
		
		Period nascimentoAteHoje = Period.between(birthday, base);
		System.out.println(nascimentoAteHoje.getYears());
		System.out.println(nascimentoAteHoje.getMonths());
		System.out.println(nascimentoAteHoje.getDays());
		
		System.out.println("**** FORMATAÇÃO DE DATAS E CONVERSÃO DE TEXTOS ******");
		
		//Formatando e convertendo em texto
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy MM dd");
		System.out.println(formatter.format(birthday));
		
		LocalDate d6 = LocalDate.parse("21/04/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(d6);
		System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(d6));
		
		System.out.println(YearMonth.now().isSupported(ChronoUnit.MONTHS));
	    System.out.println(YearMonth.now().isSupported(ChronoField.DAY_OF_MONTH));
	    System.out.println(MonthDay.now().isSupported(ChronoField.DAY_OF_MONTH));
	    System.out.println(LocalDate.now().isSupported(ChronoUnit.DAYS));
	    System.out.println(LocalDate.now().isSupported(ChronoUnit.YEARS));
	    System.out.println(LocalDate.now().isSupported(ChronoField.HOUR_OF_AMPM));
	    System.out.println(LocalDateTime.now().isSupported(ChronoField.HOUR_OF_AMPM));
	    System.out.println(LocalDateTime.now().isSupported(ChronoField.YEAR));
	    
	}

}
