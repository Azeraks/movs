package org.example;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "create")
public class Calculator {
    int add(int a, int b) {
        return a + b;
    }
}

