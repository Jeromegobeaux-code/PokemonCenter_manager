package be.technofutur.springexorecap.controllers;


import be.technofutur.springexorecap.entities.ProductEntity;
import be.technofutur.springexorecap.models.ProductDetailDto;
import be.technofutur.springexorecap.models.ProductDto;
import be.technofutur.springexorecap.repositories.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class shopController {


    private final ProductRepo productRepo;

    @PreAuthorize("isAuthenticated()")
    @GetMapping()
    public String showProducts(Model model)
    {

        List<ProductEntity> productEntities = productRepo.findAll();


        List<ProductDto>  Dtos = productEntities.stream().map(productEntity -> ProductDto.entityToDto(productEntity)).toList();

        model.addAttribute("products", Dtos);

        return "product pages/products.html";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public String showProduct(Model model, @PathVariable Integer id)
    {
        ProductDetailDto product = ProductDetailDto.DetailDtoFromEntity(productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id)));
        System.out.println(product.name());
        System.out.println(product.category());
        model.addAttribute("product", product);

        return  "product pages/detail.html";
    }



}
