package com.simplilearn.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void testAdd() {
        // Mock HttpServletRequest and HttpServletResponse objects
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Set up request parameters
        when(request.getParameter("num1")).thenReturn("3");
        when(request.getParameter("num2")).thenReturn("5");
        when(request.getParameter("operation")).thenReturn("add");

        // Instantiate the CalculatorController
        CalculatorController controller = new CalculatorController();

        // Call the calculate method
        ModelAndView modelAndView = controller.calculate(request, response);

        // Check if the view name is "result"
        assertEquals("result", modelAndView.getViewName(), "View name should be 'result'");

        // Check if the result is as expected
        assertEquals(8.0, modelAndView.getModel().get("result"), "Addition of 3 and 5 should be 8");
    }

}
