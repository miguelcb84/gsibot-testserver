package es.upm.dit.gsi.gsibot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "talktobot" path)
 */
@Path("talktobot")
public class TalkToBot {

	/**
	 * 
	 * <p>
	 * This produces a dummy response in JSON when
	 * <tt>Accept: application/json;</tt> header is provided within the
	 * <tt>request</tt>. Using <tt>Accept</tt> header overrides query parameter
	 * <tt>type</tt>.
	 * </p>
	 * 
	 * <p>
	 * The format of the JSON is presented below. The root element is
	 * <tt>dialog</tt>. Several elements included are mandatory and others are
	 * optional, only included when requested.
	 * </p>
	 * 
 	 * <ul>
	 * <li><b>bot</b>(mandatory): The name of the bot</li>
	 * <li><b>q</b>(mandatory): The query included by the user</li>
	 * <li><b>response</b>(mandatory): The response given by the bot. This field
	 * may also be duplicated in case several responses are given.</li>
	 * <li><b>userid</b>(mandatory): The username or the session id with
	 * non-authenticated services</li>
	 * <li>Any other element may be included if requested by the user.</li>
	 * </ul>
	 * 
	 * <pre>
	 * {"dialog" :{
	 *     "userid" : "Userid here",
	 *     "bot" : "The botname",
	 *     "q" : "The query included by the user",
	 *     "response" : "The response given by the bot",
	 *     "mood" : "The mood of the bot (optional)",
	 *     "url" : "Redirecting url (optional)",
	 *     "test" : "Unique response for testing purposes (optional)" 
	 * }}
	 * </pre>
	 * 
	 * 
	 * @param q
	 *            The query
	 * @param bot
	 *            The bot name
	 * @return The response in JSON
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getJson(@QueryParam("q") String q, 
						  @QueryParam("bot") String bot){
		
		return "{\"diaglog\":{"
				+ "\"userid\":\"Userid here\","
				+ "\"bot\":\"" + bot + "\","
				+ "\"q\":\"" + q +"\","
				+ "\"response\":\"The username or the session id\","
				+ "\"mood\":\"The mood of the bot (optional)\","
				+ "\"url\":\"Redirecting url (optional)\","
				+ "\"test\":\"Unique response for testing purposes (optional)\""
				+ "}}";
	}
	
	/**
	 * <p>
	 * This produces a dummy response in XML when
	 * <tt>Accept: application/xml;</tt> or <tt>Accept: text/xml;</tt> header is
	 * provided within the <tt>request</tt>. Using <tt>Accept</tt> header
	 * overrides query parameter <tt>type</tt>.
	 * </p>
	 * 
	 * <p>
	 * The format of the XML is presented below. The root element is
	 * <tt>&lt;dialog&gt;</tt>. Several elements included within the
	 * <tt>&lt;dialog&gt;</tt> element are mandatory and others are optional,
	 * only included when requested.
	 * </p>
	 * 
	 * <ul>
	 * <li><b>bot</b>(mandatory): The name of the bot</li>
	 * <li><b>q</b>(mandatory): The query included by the user</li>
	 * <li><b>response</b>(mandatory): The response given by the bot. This field
	 * may also be duplicated, in case several responses are given. In case of a
	 * multi-response it is mandatory to include a <tt>order</tt> attribute.</li>
	 * <li><b>userid</b>(mandatory): The username or the session id with
	 * non-authenticated services</li>
	 * <li>Any other element may be included if requested by the user.</li>
	 * </ul>
	 * 
	 * <pre>
	 * &lt;dialog&gt;
	 *   &lt;userid&gt;Userid here&lt;/userid&gt;
	 *   &lt;bot&gt;The botname&lt;/bot&gt;
	 *   &lt;q&gt;The query included by the user&lt;/q&gt;
	 *   &lt;response&gt;The response given by the bot&lt;/response&gt;
	 *   &lt;mood&gt;The mood of the bot (optional)&lt;/mood&gt;
	 *   &lt;url&gt;Redirecting url (optional)&lt;/url&gt;
	 *   &lt;test&gt;Unique response for testing purposes (optional)&lt;/test&gt;   
	 * &lt;/dialog&gt;
	 * </pre>
	 * 
	 * @param q
	 *            The query
	 * @param bot
	 *            The bot name
	 * @return The response in Xml
	 */
	@GET
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML})
	public String getXml(@QueryParam("q") String q, 
			  			 @QueryParam("bot") String bot){
		
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<dialog>"
				+ "  <userid>the_user_id_or_session_id_with_non_authentication_services</userid>"
				+ "  <bot>" + bot + "</bot>"
				+ "  <q>" + q + "</q>"
				+ "  <response>The response to the question given</response>"
				+ "  <mood>Happy</mood>"
				+ "  <test>dummy-test-value</test>"
				+ "  <url>https://github.com/miguelcb84/gsibot-testserver</url>"
				+ "</dialog>";
	}
	
	/**
	 * <p>
	 * This produces a dummy response in XML when
	 * <tt>Accept: application/xml;</tt> or <tt>Accept: text/xml;</tt> header is
	 * provided within the <tt>request</tt>. Using <tt>Accept</tt> header
	 * overrides query parameter <tt>type</tt>.
	 * </p>
	 * 
	 * <p>
	 * The format of the XML is presented below. The root element is
	 * <tt>&lt;dialog&gt;</tt>. Several elements included within the
	 * <tt>&lt;dialog&gt;</tt> element are mandatory and others are optional,
	 * only included when requested.
	 * </p>
	 * 
	 * <ul>
	 * <li><b>bot</b>(mandatory): The name of the bot</li>
	 * <li><b>q</b>(mandatory): The query included by the user</li>
	 * <li><b>response</b>(mandatory): The response given by the bot. This field
	 * may also be duplicated, in case several responses are given. In case of a
	 * multi-response it is mandatory to include a <tt>order</tt> attribute.</li>
	 * <li><b>userid</b>(mandatory): The username or the session id with
	 * non-authenticated services</li>
	 * <li>Any other element may be included if requested by the user.</li>
	 * </ul>
	 * 
	 * <pre>
 	 * &lt;!DOCTYPE html&gt;
	 * &lt;html&gt;
	 *   &lt;head&gt;
	 *     &lt;title&gt;GsiBot Server Mock v1.0&lt;/title&gt;
	 *   &lt;/head&gt;
	 *   &lt;body&gt;
	 *     &lt;p&gt;Userid:&lt;/p&gt;
	 *     &lt;p id=\"userid\"&gt;The username&lt;/p&gt;
	 *     &lt;p&gt;Bot:&lt;/p&gt;
	 *     &lt;p id=\"bot\"&gt;The botname&lt;/p&gt;
	 *     &lt;p&gt;Question:&lt;/p&gt;
	 *     &lt;p id=\"q\"&gt;The query of the user&lt;/p&gt;
	 *     &lt;p&gt;Response:&lt;/p&gt;
	 *     &lt;p id=\"response\"&gt;The response of the bot&lt;/p&gt;
	 *   &lt;body&gt;
	 * &lt;/html&gt;
	 * </pre>
	 * 
	 * @param q
	 *            The query
	 * @param bot
	 *            The bot name
	 * @return The response in Html
	 */
	@GET
	@Produces({MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
	public String getHtml(@QueryParam("q") String q, 
						  @QueryParam("bot") String bot){
		
		return "<!DOCTYPE html>"
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
	}
}
