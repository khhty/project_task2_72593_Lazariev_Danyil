package pl.vistula.edu.firstrestapisprin.product.support;

import pl.vistula.edu.firstrestapisprin.shared.api.response.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.vistula.edu.firstrestapisprin.product.support.exception.ProductNotFoundException;

@ControllerAdvice
public class ProductExceptionAdvisor {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse handleProductNotFound(ProductNotFoundException e) {
        return new ErrorMessageResponse(e.getMessage());
    }
}
