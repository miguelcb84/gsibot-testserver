package es.upm.dit.gsi.gsibot;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import es.upm.dit.gsi.gsibot.TalkToBot;

public class TalktobotTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(TalkToBot.class);
	}

	@Test
	public void testGetJson() {
		String q = "QName";
		String bot = "BotName";
		final String responseMsg = target().path("talktobot")
				.queryParam("q", q).queryParam("bot", bot)
				.request(MediaType.APPLICATION_JSON).get(String.class);

		String response = "{\"diaglog\":{"
				+ "\"userid\":\"Userid here\","
				+ "\"bot\":\""
				+ bot
				+ "\","
				+ "\"q\":\""
				+ q
				+ "\","
				+ "\"response\":\"The username or the session id\","
				+ "\"mood\":\"The mood of the bot (optional)\","
				+ "\"url\":\"Redirecting url (optional)\","
				+ "\"test\":\"Unique response for testing purposes (optional)\""
				+ "}}";

		assertEquals(response, responseMsg);
	}
	
	@Test
	public void testGetTextXml() {
		String q = "QName";
		String bot = "BotName";
		final String responseMsg = target().path("talktobot")
				.queryParam("q", q).queryParam("bot", bot)
				.request(MediaType.TEXT_XML).get(String.class);
		
		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<dialog>"
				+ "  <userid>the_user_id_or_session_id_with_non_authentication_services</userid>"
				+ "  <bot>" + bot + "</bot>"
				+ "  <q>" + q + "</q>"
				+ "  <response>The response to the question given</response>"
				+ "  <mood>Happy</mood>"
				+ "  <test>dummy-test-value</test>"
				+ "  <url>https://github.com/miguelcb84/gsibot-testserver</url>"
				+ "</dialog>";
		
		assertEquals(response, responseMsg);
	}
	
	@Test
	public void testGetAppXml() {
		String q = "QName";
		String bot = "BotName";
		final String responseMsg = target().path("talktobot")
				.queryParam("q", q).queryParam("bot", bot)
				.request(MediaType.APPLICATION_XML).get(String.class);
		
		String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<dialog>"
				+ "  <userid>the_user_id_or_session_id_with_non_authentication_services</userid>"
				+ "  <bot>" + bot + "</bot>"
				+ "  <q>" + q + "</q>"
				+ "  <response>The response to the question given</response>"
				+ "  <mood>Happy</mood>"
				+ "  <test>dummy-test-value</test>"
				+ "  <url>https://github.com/miguelcb84/gsibot-testserver</url>"
				+ "</dialog>";
		
		assertEquals(response, responseMsg);
	}
	
	@Test
	public void testGetTextHtml() {
		String q = "QName";
		String bot = "BotName";
		final String responseMsg = target().path("talktobot")
				.queryParam("q", q).queryParam("bot", bot)
				.request(MediaType.TEXT_HTML).get(String.class);
		
		String response = "<!DOCTYPE html>"
				+ "<html>"
				+ "  <head>"
				+ "    <title>GsiBot Server Mock v1.0</title>"
				+ "  </head>"
				+ "  <body>"
				+ "    <p>Userid:</p>"
				+ "    <p id=\"userid\">The username</p>"
				+ "    <p>Bot:</p>"
				+ "    <p id=\"bot\">" + bot + "</p>"
				+ "    <p>Question:</p>"
				+ "    <p id=\"q\">" + q + "</p>"
				+ "    <p>Response:</p>"
				+ "    <p id=\"response\">The response of the bot</p>"
				+ "  <body>"
				+ "</html>";
		
		assertEquals(response, responseMsg);
	}
	
	@Test
	public void testGetHtmlPlain() {
		String q = "QName";
		String bot = "BotName";
		final String responseMsg = target().path("talktobot")
				.queryParam("q", q).queryParam("bot", bot)
				.request(MediaType.TEXT_PLAIN).get(String.class);
		
		String response = "<!DOCTYPE html>"
				+ "<html>"
				+ "  <head>"
				+ "    <title>GsiBot Server Mock v1.0</title>"
				+ "  </head>"
				+ "  <body>"
				+ "    <p>Userid:</p>"
				+ "    <p id=\"userid\">The username</p>"
				+ "    <p>Bot:</p>"
				+ "    <p id=\"bot\">" + bot + "</p>"
				+ "    <p>Question:</p>"
				+ "    <p id=\"q\">" + q + "</p>"
				+ "    <p>Response:</p>"
				+ "    <p id=\"response\">The response of the bot</p>"
				+ "  <body>"
				+ "</html>";
		
		assertEquals(response, responseMsg);
	}
}
