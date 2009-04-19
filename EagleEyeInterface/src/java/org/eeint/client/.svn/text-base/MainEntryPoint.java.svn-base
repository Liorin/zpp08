package org.eeint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.google.gwt.user.client.ui.RootPanel;

public class MainEntryPoint implements EntryPoint, WindowResizeListener {

    private static MainEntryPoint singleton;

    public native void reload() /*-{
    $wnd.location.reload();
    }-*/;

    void login(String login) {
        Cookies.setCookie("user", login);
        layoutManager = new OwnerScreen();
        RootPanel.get("content").remove(logger);
        RootPanel.get("content").add(layoutManager);
        layoutManager.topPanel.login(login);
    }

    public void logout() {
        Cookies.removeCookie("user");
        reload();
    }

    public static MainEntryPoint get() {
        return singleton;
    }
    private LoginScreen logger = new LoginScreen();
    public OwnerScreen layoutManager;

    public void onModuleLoad() {
        singleton = this;

        Window.addWindowResizeListener(this);
        Window.setTitle("Eagle Eye Title");

        if (Cookies.getCookie("user") == null) {
            RootPanel.get("content").add(logger);
        } else {
            login(Cookies.getCookie("user"));
        }

        DeferredCommand.addCommand(new Command() {

            public void execute() {
                onWindowResized(Window.getClientWidth(), Window.getClientHeight());
            }
        });

        onWindowResized(Window.getClientWidth(), Window.getClientHeight());

    }

    public void onWindowResized(int width, int height) {
        // Adjust the shortcut panel and detail area to take up the available room
        // in the window.
        Window.setMargin("0px");
    }
}
