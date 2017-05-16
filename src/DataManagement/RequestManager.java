package DataManagement;

import java.util.ArrayList;
import java.util.List;

public class RequestManager
{
	private static boolean checkVersion ( int clientVer )
	{
		return clientVer == VersionManager.getVersion();
	}
	
	private static List<Object> getSubMenu ( String langName )
	{
		throw new UnsupportedOperationException( "Not Yet Implemented" );
	}
	
	/**
	 * Returns the appropriate response to be sent to the client for the request
	 * received.
	 * <p>
	 * This method receives requests from the client interface and calls the
	 * appropriate local methods in order to create the desired response. Once
	 * an Object List has been built, containing both the response tag and any
	 * appropriate data, it is returned to the client interface so it can be
	 * sent to the client.
	 * <p>
	 * STILL IN DEVELOPMENT... Currently the method will throw not implemented
	 * exceptions when a sub menu is requested, or if the version number is out
	 * of date.
	 * 
	 * @param request	The string that was received from the client
	 * @return			A list containing both the tag and any necessary data for the client
	 * 
	 */
	public static List<Object> makeRequest ( String request )
	{
		String[] tmp = request.split( "|" );
		List<Object> returnList = new ArrayList();
		
		try
		{
			switch ( tmp[0] )
			{
				case "version":
					if ( checkVersion( Integer.parseInt( tmp[1] ) ) )
					{
						returnList.add( "version_ok" );
					}
					else
					{
						throw new UnsupportedOperationException( "Not Fully Implemented" );
						// returnList.add( "menu_list" );
					}
					break;
				case "request":
					returnList = getSubMenu( tmp[1] );
					break;
			}
		}
		catch ( UnsupportedOperationException e )
		{
			throw e;
		}
		
		return returnList;
	}
}
