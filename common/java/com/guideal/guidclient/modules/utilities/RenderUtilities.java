package com.guideal.guidclient.modules.utilities;

import com.guideal.guidclient.render.DebugLinesLineRenderer;
import com.guideal.guidclient.render.LineRenderer;

public class RenderUtilities {

    public static final RenderUtilities instance = new RenderUtilities();

    private LineRenderer lineRenderer = new DebugLinesLineRenderer();

    private RenderUtilities() {

    }

    public LineRenderer getLineRenderer() {
        return lineRenderer;
    }
}