package cordova.plugin.mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class defines 2 operations.
 * 1. Echoes a string called from JavaScript.
 * 2. Adds 2 numbers passed from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        } 
        else if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
        else if (action.equals("subtract")) {
            this.add(args, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void add(JSONArray args, CallbackContext callbackContext) {
        if (args != null) {
            try {
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                int sum = p1 + p2;
                callbackContext.success("" + sum);
            } catch (Exception e) {
                callbackContext.error("Something went wrong" + ex);
            }
        } else {
            callback.error("Please do not pass null value");
        }
    }

    private void subtract(JSONArray args, CallbackContext callbackContext) {
        if (args != null) {
            try {
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                int difference = p1 - p2;
                callbackContext.success("" + difference);
            } catch (Exception e) {
                callbackContext.error("Something went wrong" + ex);
            }
        } else {
            callback.error("Please do not pass null value");
        }
    }
}
