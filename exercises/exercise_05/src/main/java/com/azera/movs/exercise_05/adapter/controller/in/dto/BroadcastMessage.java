package com.azera.movs.exercise_05.adapter.controller.in.dto;

import com.azera.movs.exercise_05.adapter.controller.in.websocket.Operation;
import java.util.UUID;

public record BroadcastMessage(

        UUID clientID,
        Operation operation

) {}
