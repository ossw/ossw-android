package com.althink.android.ossw.emulator.watchset;

import com.althink.android.ossw.emulator.actions.EmulatorAction;
import com.althink.android.ossw.emulator.actions.EmulatorEventHandler;
import com.althink.android.ossw.emulator.control.EmulatorControl;
import com.althink.android.ossw.emulator.event.ButtonLongPressedEmulatorEvent;
import com.althink.android.ossw.emulator.event.ButtonPressedEmulatorEvent;
import com.althink.android.ossw.emulator.event.EmulatorButton;
import com.althink.android.ossw.emulator.event.EmulatorEvent;
import com.althink.android.ossw.emulator.model.EmulatorModelProperty;
import com.althink.android.ossw.emulator.renderer.EmulatorExecutionContext;
import com.althink.android.ossw.service.WatchOperationContext;
import com.althink.android.ossw.watch.WatchConstants;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by krzysiek on 14/06/15.
 */
public class WatchSetEmulatorModel {

    private int id;
    List<WatchSetScreenEmulatorModel> screens;
    private int currentScreen;
    private Map<EmulatorEvent, EmulatorAction> eventMapping = new HashMap<>();
    private Map<Integer, byte[]> resources;

    private WatchOperationContext operationContext;


    public WatchSetEmulatorModel(int id) {
        this.id = id;
    }

    private EmulatorEvent buildEventForId(int eventId) {
        switch (eventId) {
            case WatchConstants.EVENT_BUTTON_UP_SHORT:
                return new ButtonPressedEmulatorEvent(EmulatorButton.UP);
            case WatchConstants.EVENT_BUTTON_SELECT_SHORT:
                return new ButtonPressedEmulatorEvent(EmulatorButton.SELECT);
            case WatchConstants.EVENT_BUTTON_DOWN_SHORT:
                return new ButtonPressedEmulatorEvent(EmulatorButton.DOWN);
            case WatchConstants.EVENT_BUTTON_BACK_SHORT:
                return new ButtonPressedEmulatorEvent(EmulatorButton.BACK);
            case WatchConstants.EVENT_BUTTON_UP_LONG:
                return new ButtonLongPressedEmulatorEvent(EmulatorButton.UP);
            case WatchConstants.EVENT_BUTTON_SELECT_LONG:
                return new ButtonLongPressedEmulatorEvent(EmulatorButton.SELECT);
            case WatchConstants.EVENT_BUTTON_DOWN_LONG:
                return new ButtonLongPressedEmulatorEvent(EmulatorButton.DOWN);
            case WatchConstants.EVENT_BUTTON_BACK_LONG:
                return new ButtonLongPressedEmulatorEvent(EmulatorButton.BACK);
        }
        return null;
    }

    public WatchSetEmulatorModel(List<WatchSetScreenEmulatorModel> screens) {
        this.screens = screens;
    }

    public List<EmulatorControl> getCurrentScreenControls() {
        return screens.get(currentScreen).getControls();
    }

    public List<EmulatorEventHandler> getCurrentScreenActions() {
        return screens.get(currentScreen).getActions();
    }

    public Map<Integer, EmulatorModelProperty> getCurrentScreenModel() {
        return screens.get(currentScreen).getModel();
    }

    public void setScreens(List<WatchSetScreenEmulatorModel> screens) {
        this.screens = screens;
        setCurrentScreen(0);
    }

    public WatchOperationContext getOperationContext() {
        return operationContext;
    }

    public void setOperationContext(WatchOperationContext operationContext) {
        this.operationContext = operationContext;
    }

    public int getId() {
        return id;
    }

    public EmulatorAction getActionForEvent(EmulatorEvent event) {
        return eventMapping.get(event);
    }

    public void setCurrentScreen(int i) {
        currentScreen = i;
        eventMapping.clear();
        List<EmulatorEventHandler> currentScreenActions = getCurrentScreenActions();
        if (currentScreenActions != null) {
            for (EmulatorEventHandler eventHandler : currentScreenActions) {
                EmulatorEvent event = buildEventForId(eventHandler.getEventId());
                eventMapping.put(event, eventHandler.getAction());
            }
        }

        if (getCurrentScreenModel() != null) {
            Collection<EmulatorModelProperty> modelProperties = getCurrentScreenModel().values();
            for (EmulatorModelProperty property : modelProperties) {
                property.initialize();
            }
        }
    }

    public void setResources(Map<Integer, byte[]> resources) {
        this.resources = resources;
    }

    public Map<Integer, byte[]> getResources() {
        return resources;
    }

}
