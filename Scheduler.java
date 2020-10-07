package task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Scheduler {

	Timer timer;

	// Executa uma tarefa diariamente no horário determinado
	public void dailyTask(String hour) { // Ex.: 03h00

		timer = new Timer();

		SimpleDateFormat sdf = new SimpleDateFormat("hh.mm");
		float now = Float.parseFloat(sdf.format(new Date()));
		float time = Float.parseFloat(hour.substring(0, 2) + "." + hour.substring(3, 5));
		int delay;
		if (now < time) { // No mesmo dia
			delay = (int) ((time - now) * 60 * 60 * 1000);
		} else { // No dia seguinte
			delay = (int) ((24 - now + time) * 60 * 60 * 1000);
		}
		int interval = 24 * 60 * 60 * 1000; // 24h

		timer.schedule(new Task(), delay, interval);

	}

	public void taskCancel() {
		timer.cancel();
	}

}
