package com.iyher.eclipse.kdoc

import org.jetbrains.kotlin.ui.editors.hover.KotlinEditorTextHover
import org.eclipse.jface.text.IInformationControlCreator;
import org.jetbrains.kotlin.kdoc.lexer.KDocTokens;
import org.jetbrains.kotlin.ui.editors.KotlinEditor;
import org.jetbrains.kotlin.ui.editors.hover.HoverData;

class KDocHover : KotlinEditorTextHover<String> {
	override fun getHoverInfo(hoverData: HoverData): String? {
		return null
	}

	override fun isAvailable(hoverData: HoverData): Boolean {
		return false
	}

	override fun getHoverControlCreator(editor: KotlinEditor): IInformationControlCreator? {
		return null
	}
}