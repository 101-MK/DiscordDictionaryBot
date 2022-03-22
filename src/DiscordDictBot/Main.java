package DiscordDictBot;

	import javax.security.auth.login.LoginException;

	import net.dv8tion.jda.api.JDA;
	import net.dv8tion.jda.api.JDABuilder;
	import net.dv8tion.jda.api.OnlineStatus;
	import net.dv8tion.jda.api.entities.*;

	public class Main {
		public static JDA jda;
		public static String prefix = "~";
		
		public static void main(String[] args) throws LoginException {
			
			
			JDA jda = JDABuilder.createDefault("Nzc0ODk3NjEzMDg1OTk5MTA1.X6edow.QI2rtbm55DP-Jh8ev-YX43ragkw").build();
			jda.getPresence().setStatus(OnlineStatus.ONLINE);
			jda.getPresence().setActivity(Activity.watching("for ~commands to be written"));
			
			jda.addEventListener(new Commands());
		}
		
		

	}

