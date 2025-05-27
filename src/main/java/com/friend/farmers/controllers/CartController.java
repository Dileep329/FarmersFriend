package com.friend.farmers.controllers;


import com.friend.farmers.models.Cart;
import com.friend.farmers.payload.CartDTO;
import com.friend.farmers.respository.CartRepository;
import com.friend.farmers.service.CartService;
import com.friend.farmers.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/carts/products/{productId}/{quantity}")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable Long productId,
                                                    @PathVariable Integer quantity) {
        CartDTO cartDTO = cartService.addProductToCart(productId, quantity);
        return new ResponseEntity<>(cartDTO, HttpStatus.CREATED);
    }

        @GetMapping("/carts")
        public ResponseEntity<List<CartDTO>> getCarts() {
            List<CartDTO> cartDTOs = cartService.getAllCarts();
            return new ResponseEntity<List<CartDTO>>(cartDTOs, HttpStatus.FOUND);
        }


        @GetMapping("/carts/users/cart")
        public ResponseEntity<CartDTO> getCartById () {
            String emailId = authUtil.loggedInEmail();
            Cart cart = cartRepository.findCartByEmail(emailId);
            Long cartId = cart.getCartId();
            CartDTO cartDTO1 = cartService.getCart(emailId, cartId);
            return new ResponseEntity<CartDTO>(cartDTO1, HttpStatus.OK);
        }

        @PutMapping("/cart/products/{productId}/quantity/{operation}")
        public ResponseEntity<CartDTO> updateCartProduct (@PathVariable Long productId,
                @PathVariable String operation){

            CartDTO cartDTO = cartService.updateProductQuantityInCart(productId,
                    operation.equalsIgnoreCase("delete") ? -1 : 1);

            return new ResponseEntity<CartDTO>(cartDTO, HttpStatus.OK);
        }

        @DeleteMapping("/carts/{cartId}/product/{productId}")
        public ResponseEntity<String> deleteProductFromCart (@PathVariable Long cartId,
                @PathVariable Long productId){
            String status = cartService.deleteProductFromCart(cartId, productId);
            return new ResponseEntity<String>(status, HttpStatus.OK);
        }
    }
