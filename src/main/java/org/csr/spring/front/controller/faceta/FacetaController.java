package org.csr.spring.front.controller.faceta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/faceta/")
public class FacetaController {

	private static final String RETURN_DETALLE_FACETA = "detalleFaceta";
	private static final String RETURN_DETALLE_TILES_FACETA = "detalleTilesFaceta";

	@RequestMapping(value = { "/detalle" }, method = RequestMethod.GET)
	public String detalleFaceta() {
		return RETURN_DETALLE_FACETA;
	}

	@RequestMapping(value = { "/detalleFaceta" }, method = RequestMethod.GET)
	public String detalleTilesFaceta() {
		return RETURN_DETALLE_TILES_FACETA;
	}
}
